echo .....dropping ctn database from postgres
set PGPASSWORD=postgres
psql -U postgres -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'ctn' AND pid <> pg_backend_pid();"
psql -U postgres -c "drop database ctn"
psql -U postgres -c "CREATE DATABASE ctn WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';"
psql -U postgres -c "ALTER DATABASE ctn OWNER TO postgres;"
@pause