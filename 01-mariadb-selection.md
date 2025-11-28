# conclusions
1. I chose mariadb b/c of my experience with mysql.  Don't want to learn postgres details.
2. I couldn't find an Mariadb install package for MacOs or Linux so
   I concluded that the productization of this accounting app would be to deliver a laptop,
   if it ever gets there.

# research residue follows
   
## mac-app-install

microsoft is a NO GO
linux because microsoft is pure evil
macos, next, its complicated

## It would be easier to setup, deploy on laptop and sell it ( give it ).

### install, uninstall mariadb

### postres
#### macos install
    https://postgresapp.com/

### linux install
   current dev env rsk@10.10.89.95

    https://mariadb.com/get-started-with-mariadb/#linux
1. Update the package list by running sudo apt update

2. Install MariaDB server by running sudo apt install mariadb-server mariadb-client

3. Secure the installation by running sudo mariadb-secure-installation

This script guides you through important security settings like setting a root password, removing anonymous users, and disabling remote root login.

4. Start the MariaDB service by running sudo systemctl start mariadb

5. Verify the installation by running mariadb -u root -p

Enter the root password you set during the secure installation step. This should log you into the MariaDB client.

### mariadb
   https://github.com/MariaDB4j/MariaDB4j

   https://www.beekeeperstudio.io/db/mariadb-client/
