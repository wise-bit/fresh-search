import requests, sys, bs4
from googlesearch import search
 
if len(sys.argv) > 1:
	for url in search(' '.join(sys.argv[1:]), stop=50):
	    if(url != ("twitter")
	    	print (url)

else:
	sys.exit('list of items not long enough')