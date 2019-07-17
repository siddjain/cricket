import math
import numpy as np
from scipy.stats import lognorm
import scipy.integrate as integrate

def create_lognormal(data):
	log_data = np.log(data)
	sigma = np.std(log_data)
	mu = np.mean(log_data)
	scale = math.exp(mu)
	return lambda x: lognorm.pdf(x, sigma, 0, scale)

def cross_correlation(f, g):
	return lambda x: f(x) * g(x)

def calculate(team1, team2):
	f = create_lognormal(team1)
	g = create_lognormal(team2)
	h = cross_correlation(f, g)
	return  integrate.quad(h, 0, float("inf"))
