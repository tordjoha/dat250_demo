# Experiment 3: Developing a frontend(SPA) for PollApp
I chose Svelte for my frontend framework. Made three components: CreateUserComponent, CreatePollComponent and VoteComponent.
- CreateUserComponent: A form to create a new user. You chose a username and write down your email.
- CreatePollComponent: A form to create a new poll. You add a question and then add as many options as you want. This makes it a bit more expansive rather then just A or B.
- VoteComponent: A form to vote on a poll. It fetches all available polls and displays them for the user to vote on.

Made some changes to the code from experiment 2. From the original domain model I added unique IDs the creation of users, as well as to polls which will make it easier to seperate when calling them.


## Technical problems
Not really a technical problem but it took some time to get to know Svelte seeing as it was a new framework for me, but 
I haven't really played around with any of the other frameworks either. Making frontend components for the backend was also
a bit tricky with just mock data as I felt that I did not get the real feel without talking directly to the backend.

## Link to code
_frontend_ folder in repository

## Pending issues
