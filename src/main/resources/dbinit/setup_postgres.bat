set PGPASSWORD=postgres
psql -U postgres -d ctn -f setup_postgres.sql
@pause