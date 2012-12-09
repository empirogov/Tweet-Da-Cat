//dataSource {
//    pooled = true
//    driverClassName = "com.mysql.jdbc.Driver"
//    url = "jdbc:mysql://i2dev.ru/tweet_da_cat"
//    dbCreate = "create-drop"
//    username = "tweet_da_cat"
//    password = "agent007"
//    dialect = org.hibernate.dialect.MySQL5Dialect
//}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://i2dev.ru/tweet_da_cat?useUnicode=yes&characterEncoding=UTF-8"
            dbCreate = "update"
            username = "tweet_da_cat"
            password = "agent007"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
        }
    }
    test {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://i2dev.ru/tweet_da_cat_test"
            dbCreate = "create-drop"
            username = "root"
            password = "frjkas"
            dialect = org.hibernate.dialect.MySQL5Dialect
            logSql = true
        }
    }
    production {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://i2dev.ru/tweet_da_cat_prod?useUnicode=yes&characterEncoding=UTF-8"
            dbCreate = "update"
            username = "tweet_da_cat"
            password = "agent007"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
        }
    }
}
