# Replay Hoster

There are a few things you need to know with how to run this project.

### Building the project

This command will clean out any leftover artifacts.
```
./gradlew clean
```
This command builds the project & places an artifact in `/build/services`
```
./gradlew compileApp
```

### Running the project
###### After the project is built, run this command to start the server. Let it be known that this server will run on port 8081 now.
```
java -jar build/services/ReplayHoster-0.0.1-SNAPSHOT.jar
```


### Using Docker
###### It works as it's set up right now.. But I don't feel like writing the whole guide right now.  I'll come back to this.

