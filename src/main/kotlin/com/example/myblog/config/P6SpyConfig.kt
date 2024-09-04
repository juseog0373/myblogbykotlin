package com.example.myblog.config

import com.p6spy.engine.logging.Category
import com.p6spy.engine.spy.P6SpyOptions
import com.p6spy.engine.spy.appender.MessageFormattingStrategy
import jakarta.annotation.PostConstruct
import org.hibernate.engine.jdbc.internal.FormatStyle
import org.springframework.context.annotation.Configuration

@Configuration
class P6SpyConfig : MessageFormattingStrategy {
    @PostConstruct
    fun setLogMessageFormat() {
        P6SpyOptions.getActiveInstance().logMessageFormat = this.javaClass.name
    }

    override fun formatMessage(
        connectionId: Int,
        now: String,
        elapsed: Long,
        category: String,
        prepared: String,
        sql: String,
        url: String
    ): String {
        var sql: String? = sql
        sql = formatSql(category, sql)
        return String.format("[%s] | %d ms | %s", category, elapsed, formatSql(category, sql))
    }

    private fun formatSql(category: String, sql: String?): String? {
        var sql = sql
        if (sql != null && !sql.trim { it <= ' ' }.isEmpty() && Category.STATEMENT.getName().equals(category)) {
            val trimmedSQL = sql.trim { it <= ' ' }.lowercase()
            sql =
                if (trimmedSQL.startsWith("create") || trimmedSQL.startsWith("alter") || trimmedSQL.startsWith("comment")) {
                    FormatStyle.DDL.getFormatter().format(sql)
                } else {
                    FormatStyle.BASIC.getFormatter().format(sql)
                }
            return sql
        }
        return sql
    }
}