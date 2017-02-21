-- When Spring Boot detects that Spring’s JDBC module and H2 are on the classpath, autoconfiguration kicks in and
-- automatically configures a JdbcTemplate bean and an H2 DataSource bean
-- it will configure thr datasource for you directly. in order to do that,
-- spring will go to the main->resources to find the schema.sql, and data.sql(if have)
-- schema.sql is the 'create table' command. and 'data.sql' will process the data
CREATE TABLE contacts (id INTEGER IDENTITY,firstName VARCHAR(30) NOT NULL ,lastName VARCHAR(50) NOT NULL, phoneNumber VARCHAR(13), emailAddress VARCHAR(30))