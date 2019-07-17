import scores
import prob as t
import numpy as np
import matplotlib.pyplot as plt
x = np.linspace(1,500,100)
fig, ax = plt.subplots(1,1)
en = t.create_lognormal(scores.en)
nz = t.create_lognormal(scores.nz)
al = t.create_lognormal(scores.all)
ax.plot(x, en(x), "r-", lw=5, alpha=0.6, label="england")
ax.plot(x, nz(x), "g-", lw=5, alpha=0.6, label="new zealand")
ax.plot(x, al(x), "b-", lw=5, alpha=0.6, label="all")
plt.legend(loc='upper right')
plt.show()
