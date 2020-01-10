
# PlayStation Time Tracker
A web application to track how much time you spend on gaming.

## Check out the deployed application on Heroku
https://playstationtimetracker.herokuapp.com/

## What is this
This is a demo project I made to get familiar with React, frontend development and the usage of APIs.
The purpose of the app is to track your gaming process by registering how many hours you spend on gaming and save this data  into your database. Also, the remaining time to finish a game is also calculated accordingly. \
For the backend I used:
  - Java
  - Spring Boot
  - JPA with Hibernate
  - JawsDB MySQL
  - Lombok
  - JSON Web Token

Currently playtime is modified so it counts hours instead of millisecond for testing purposes.

This repo contains the backend part of the application. 
The frontend can be found here : https://github.com/drszabodavid/playstationtimetracker

## How to use

On the homepage the user gets the trending games with the estimated time it takes to finish them.


![frontpage](https://user-images.githubusercontent.com/35307122/71980778-2ab47300-3221-11ea-8935-4b79d3000fcd.png)

Before able to track a new game, the user need to be registered in the database and then log into his/her own account. This can be done on the registration and login pages.

![newregistration](https://user-images.githubusercontent.com/35307122/71980705-08baf080-3221-11ea-9385-559919d327a4.png)

![newlogin](https://user-images.githubusercontent.com/35307122/71980689-fe98f200-3220-11ea-9d6c-b12023a24dd8.png)

After registration new games can be added to the user's game list by clicking on the chosen game.

![newsearch](https://user-images.githubusercontent.com/35307122/71980724-12445880-3221-11ea-99b8-a9047fc9df8a.png)

Under 'My Games' the user can see his/her saved games and additional data.\
Games can be starred, marked as completed, reopened and deleted from the list.\
The starred games are filtered on the 'Starred' tab and the completed ones on the 'Completed' tab.\
If the timer is started it counts the gaming time and if paused, the interval gets added to 'My Time' field and the new 'Remaining Time' is calculated.

![newtable](https://user-images.githubusercontent.com/35307122/71980755-1e301a80-3221-11ea-8de0-8817ded08978.png)

## Future plans

I would like to make the app equally responsive for different screen sizes and I'd also like to implement the possibility to import the users game list during registration using the username and scrape the data from psnprofiles.com.
