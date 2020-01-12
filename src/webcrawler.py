import requests, sys, bs4
from googlesearch import search
from bs4 import BeautifulSoup
from urllib.request import urlopen
 
if len(sys.argv) > 1:
	term = ' '.join(sys.argv[1:])
	urllist = []
	finalurl = []
	for url in search(term, tld='com', stop=10):
		if("ebay.com" not in url and "youtube.com" not in url and "pintrest.com" not in url and "spotify.com" not in url and "twitter.com" not in url and "facebook.com" not in url and "amazon.com" not in url and "amazon.ca" not in url and "reddit.com" not in url):
			if(term in url):
				print(url)
				urllist.append(url)
	print(urllist)

	for i in urllist:
		soup = BeautifulSoup(urlopen(i), features="lxml")
		for link in soup.find_all('a'):
			word = link.get('href')
			if("ebay.com" not in word and "youtube.com" not in word and "pintrest.com" not in word and "spotify.com" not in word and "twitter.com" not in word and "facebook.com" not in word and "amazon.com" not in word and "amazon.ca" not in word and "reddit.com" not in word and word.startswith("http")):
				if(term in word):
	 				finalurl.append(link.get('href'))

	print(finalurl)

else:
	sys.exit('list of items not long enough')