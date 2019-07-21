import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import  norm
import math
plt.rcParams.update({'font.size': 30})
actual = pd.read_csv('odi_summary.txt', sep=" ", header=None)
runs = actual[1]
mu = runs.mean()
sigma = runs.std()
pdf = lambda x: norm.pdf(x, mu, sigma)
n_equal_bins=20
bins = np.linspace(start=0, stop=500, num=n_equal_bins + 1, endpoint=True)
# If bins is a sequence, it defines a monotonically increasing array of bin edges,
# including the rightmost edge  
# https://docs.scipy.org/doc/numpy/reference/generated/numpy.histogram.html
H, _ = np.histogram(runs, bins) # returns the frequency of counts
k = max(H) / pdf(mu)    # this is a scale factor so we can superimpose pdf curve
fig, ax = plt.subplots(1, 1)
plt.hist(x=runs, bins=bins, color='#0504aa', alpha=0.7, rwidth=0.85)
ax.plot(bins, k * pdf(bins), "b-", lw=5, alpha=0.6, label="Gaussian fit")
plt.text(350, 350, r'$\mu={mu}, \sigma={sigma}$'.format(mu=mu, sigma=sigma))
ax.set_ylabel('Frequency')
ax.set_xlabel("Runs")
ax.grid(axis='y')
plt.legend(loc='upper right')
plt.xlim(0, 500)
plt.show()