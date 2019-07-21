import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import  norm

def plot(file, col, start=0, stop=500, num_bins=20):
    plt.rcParams.update({'font.size': 30})
    actual = pd.read_csv(file, sep=" ", header=None)
    runs = actual[col]
    mu = runs.mean()
    sigma = runs.std()
    pdf = lambda x: norm.pdf(x, mu, sigma)
    bins = np.linspace(start=start, stop=stop, num=num_bins + 1, endpoint=True)
    # If bins is a sequence, it defines a monotonically increasing array of bin edges,
    # including the rightmost edge  
    # https://docs.scipy.org/doc/numpy/reference/generated/numpy.histogram.html
    H, _ = np.histogram(runs, bins) # returns the frequency of counts
    k = max(H) / pdf(mu)    # this is a scale factor so we can superimpose pdf curve
    fig, ax = plt.subplots(1, 1)
    plt.hist(x=runs, bins=bins, color='#0504aa', alpha=0.7, rwidth=0.85)
    ax.plot(bins, k * pdf(bins), "b-", lw=5, alpha=0.6, label="Gaussian fit")
    plt.text(stop * 0.75, max(H) * 0.75, r'$\mu={mu}, \sigma={sigma}$'.format(mu=mu, sigma=sigma))
    ax.set_ylabel('Frequency')
    ax.set_xlabel("Runs")
    ax.grid(axis='y')
    plt.legend(loc='upper right')
    plt.xlim(start, stop)
    plt.show()