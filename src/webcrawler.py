import requests, sys, bs4
from googlesearch import search
from bs4 import BeautifulSoup
from urllib.request import urlopen












##################
depth = 5
##################














print("fricc")

if len(sys.argv) > 1:
	term = ' '.join(sys.argv[1:])
	#creates list of url
	urllist = []
	finalurl = []
	#loops through the array, 
	for url in search(term, tld='com', stop=depth, pause=0.01):
		if("ebay.com" not in url and "youtube.com" not in url and "pinterest.com" not in url and "spotify.com" not in url and "twitter.com" not in url and "facebook.com" not in url and "amazon.com" not in url and "amazon.ca" not in url and "reddit.com" not in url):
			if(term in url):
				# print(url)
				urllist.append(url)
	# print(urllist)
	# print("------------------------------------------------------------------------------------------------")

	# for i in urllist:
	# 	try:
	# 		soup = BeautifulSoup(urlopen(i), features="lxml")
	# 	except:
	# 		continue
	# 	for link in soup.find_all('a'):
	# 		word = link.get("href", "")
	# 		if("ebay.com" not in word and "youtube.com" not in word and "pinterest.com" not in word and "spotify.com" not in word and "twitter.com" not in word and "facebook.com" not in word and "amazon.com" not in word and "amazon.ca" not in word and "reddit.com" not in word and word.startswith("http")):
	# 			if(term in word):
	#  				urllist.append(word)

	#print(finalurl)
	sys.exit(urllist);

else:
	sys.exit('list of items not long enough')
