To calculate probability of a:
* zero
* one
* two
* three
* four
* five
* six
* extra ball
* out
and average runs on extra ball, run following commands from python prompt

```
>>> import pandas as pd
>>> data = pd.read_csv('odi_prob.txt', sep=" ", header=None)
>>> M=data.mean(axis=0,skipna=True,numeric_only=True)
>>> M
1     0.515492
2     0.305435
3     0.052684
4     0.007073
5     0.076999
6     0.000193
7     0.013303
8     0.039290
9     0.028815
10    1.283108
dtype: float64
```