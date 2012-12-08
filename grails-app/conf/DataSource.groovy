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
            url = "jdbc:mysql://i2dev.ru/tweet_da_cat"
            dbCreate = "update"
            username = "tweet_da_cat"
            password = "agent007"
            dialect = org.hibernate.dialect.MySQL5Dialect
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
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
