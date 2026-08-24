# Learning Tasks

A small archive of completed programming exercises. The repository currently contains two independent projects; items that were only proposed have been removed from the project list to avoid implying that they were implemented here.

## Analog and digital clock

A dependency-free browser exercise that renders an analog clock with CSS and a digital clock with JavaScript.

1. Open `analog-digital-clock/index.html` in a browser.
2. Use the **Switch to digital/analog clock** button to change the view.

The clock face is generated locally with CSS and does not load third-party images.

## Placement-drive interview allocation

A Java exercise that randomly assigns candidates to interviewers for two rounds. Every round-two candidate is assigned to a different interviewer than in round one.

Requirements: Java 11 or newer.

From `interviewer-interviewee/PlacementDriveSelection`:

```bash
javac -d out src/module-info.java src/com/placement/drive/PlacementDrive.java
java --module-path out --module PlacementDriveSelection/com.placement.drive.PlacementDrive
```

The program requires at least two interviewers and a positive number of candidates. Generated `.class` files and IDE output are excluded from version control.

## Status

These projects are retained as educational exercises, not production applications. They do not process real user data or require credentials.
