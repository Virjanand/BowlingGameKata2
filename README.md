# Bowling game kata
Another description: https://codingdojo.org/kata/Bowling/
Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game. Here are some things that the program will not do:

We will not check for valid rolls.
We will not check for correct number of rolls and frames.
We will not provide scores for intermediate frames.
Depending on the application, this might or might not be a valid way to define a complete story, but we do it here for purposes of keeping the kata light. I think you’ll see that improvements like those above would go in readily if they were needed for real.

We can briefly summarize the scoring for this form of bowling:

Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
In each frame, the bowler gets up to two tries to knock down all the pins.
If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
If in two tries he knocks them all down, this is called a “spare” and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
If on his first try in the frame he knocks down all the pins, this is called a “strike”. His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
The game score is the total of all frame scores.
More info on the rules at: How to Score for Bowling

Clues
What makes this game interesting to score is the lookahead in the scoring for strike and spare. At the time we throw a strike or spare, we cannot calculate the frame score: we have to wait one or two frames to find out what the bonus is.

Suggested Test Cases
(When scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)

X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150

## TODO list:
- [x] sum rolls: "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" -> getScore -> 20
- [x] miss(-) is 0 points: "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> getScore -> 0
- [x] strike(X) is ten points: "X", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> getScore -> 10
- [x] add next 2 rolls to strike score: "X", "1", "1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> getScore -> 14
- [x] strike after strike is added as 10 points: "X", "X", "1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> getScore -> 33
- [x] spare (roll and /) together ten points: "1", "/", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> 10
- [ ] ~~refactor if statements to use polymorphism~~
- [x] add next roll to spare score: "1", "/", "1", "1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" -> 13
- [x] check for strikes at end: "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "X", "X", "X" -> getScore -> 60
- [x] check for spare at end: "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "/", "X" -> getScore -> 20
