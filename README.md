### Local Database Setup

1. Clone the repository.

2. Create a `.env` file in the root directory with the following content:

   POSTGRES_USER=app_user
   
   POSTGRES_PASSWORD=securepassword
   
   POSTGRES_DB=task_management
   
   POSTGRES_PORT=5432

4. Run the following command to start the database:
   
   docker-compose up -d

6. Connect to the database using any SQL client (e.g., DBeaver):

   - Host: `localhost`
   - Port: `5432`
   - Database: `task_management`
   - Username: `app_user`
   - Password: `securepassword`

7. Run the following test query:
   
   SELECT version();

Stopping the Database:

    docker-compose down
