docker build -t jailbook_database .
docker run --name jailbook_db -p 3306:3306 jailbook_database
