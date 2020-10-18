# Heavy Goal Tracker by: Aldana
## Weight Tracker for Android

### Requirement and Design Summary
This weight tracking app is used to track the daily weight of a user and show progress.  The app is deployed with a database using the integrated SQLite functionality so that it can store login information, daily weight activity and a goals.   It includes a log in screen with new user registration and password reset functionality to provide users with easy profile management.   Next the Main Activity (Home Screen) is a dashboard which includes a current weight display with relational target goal.  There are navigational buttons that allow the user to enter Current and Target weights with are recorded with Date/Time stamps.

The User Interface keeps users in mind by keeping navigation and functionality very simple.  By doing so, the designs were also easy to implement which made the application successful and easy to deploy.

### Coding Approach, Techniques, and Design
The Main approach I took to Coding my project is keeping scalability and simplicity in mind.   I created JAVA classes different databases to service different functionality of the app while also designing methods that were repeatable throughout the solution.   For example, there were many instances where I used toast commands to display information necessary to keep the app moving.   By creating a Toast Method in every activity, I was able to call the method whenever necessary as opposed to instantiating a new toast intent every time I needed it.  It is this approach that I used throughout.

### Testing
I tested my code through an emulator in Android Studio and also deployed the app on my personal phone.  This testing was important because it helped me have an experience with the layout of the UI and also gave me a first hand experience of the functionality.   The process was important because after every test I was able to clean up general functionality bug, while also optimizing the UI.


### Initial Planning to Finalization
There were several functionalities that I included and did not include in the initial planning phase that either did not make the cut or had to be added.  In the initial planning stage I did not anticipate more than one activity being required for resetting a password.  I found however that by adding a reset password activity as opposed to a credential email, the app becomes simpler for a User.   Next, I originally planned to include a status bar to show the progress of current weight and target weight.   In this case, I abandoned the status bar altogether because it made the main activity too cluttered which went against our principle of simplicity.

### Demonstrating Knowledge, Skills, and Experience
I feel like the development of the application was pretty straight forward.  That said, I believe the biggest area that showcases my knowledge, skills and experience with app development to be tying a successful and simple UI to the PRINCIPLE of being simple, and not over complicating things.   TO be successful in this, the developer must harness the technology available to make the user experience easy.   For this we tied internal memory to different areas of the UI and tied activities to the user experience that make the overall usability of the application, EASY.
