# Format of simulation.txt

`simulation.txt` generated by running:
```
c:\Users\siddjain\cricket\simulation>mvn exec:java -Dexec.mainClass="cricket.Simulation" -Dexec.args="config.yaml 100000" > simulation.txt
```

[config.yaml](config.yaml) contains the probabilities used to simulate a game of cricket.

Example record:
```
2 440 264 6 50.0
```

* Column 1: Thread id
* Column 2: Inning id
* Column 3: Runs
* Column 4: Wickets
* Column 5: Overs

Last line of `simulation.txt` calculates probability of a tie:
```
Prob. of tie = 972 / 100128 = 0.0097 
```
The denominator is the number of matches simulated