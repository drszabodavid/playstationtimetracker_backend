
# PlayStation Time Tracker
A web application to track how much time you spent on gaming.

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

Currently playtime is also modified so it counts hours instead of millisecond for testing purposes.

This repo contains the backend part of the application. 
The frontend can be found here : https://github.com/drszabodavid/playstationtimetracker

## How to use

On the homepage the user gets the trending games with the estimated time it takes to finish them.


![frontpage](https://user-images.githubusercontent.com/35307122/71977918-597b1b00-321a-11ea-8ea7-f7bfe3b3cc02.png)

Before able to track a new game, the user need to be registered in the database and then log into his/her own account. This can be done on the registration and login pages.

![register](https://user-images.githubusercontent.com/35307122/71977903-5122e000-321a-11ea-9b7b-fc090a306f38.png)

![login](https://user-images.githubusercontent.com/35307122/71977883-436d5a80-321a-11ea-9fd3-37443a84d980.png)

After registration new games can be added to the user's game list by clicking on the chosen game.

![search](https://user-images.githubusercontent.com/35307122/71977944-6861cd80-321a-11ea-820f-628a0112d97b.png)

Under 'My Games' the user can see his/her saved games and additional data.\
Games can be starred, marked as completed, reopened and deleted from the list.\
The starred games are filtered on the 'Starred' tab and the completed ones on the 'Completed' tab.\
If the timer is started it counts the gaming time and if paused, the interval gets added to 'My Time' field and the new 'Remaining Time' is calculated.

![table](https://user-images.githubusercontent.com/35307122/71977930-613abf80-321a-11ea-8fbf-8140c56c1603.png)

## Future plans

Currently I'm working on styling. I would like to make the app equally responsive for different screen sizes.
