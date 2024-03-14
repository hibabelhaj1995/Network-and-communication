#TCPAsk
TCPAsk is a Java application that uses the TCPClient class to communicate with a server. TCPAsk has two mandatory parameters given on the command line: the host and the port to which TCPAsk should connect. TCPAsk also takes an optional string as parameter. This string is appended with a newline character (linefeed '\n') before being converted to a byte array and sent as data to the server. So TCPAsk connects to the server, sends the optional data over the connection to the server (if there is any), decodes the data received from the server into text, and prints the text as program output.

For example, assume we want to contact the "daytime" server at "time.nist.gov". The Daytime protocol is a standardised protocol for asking a Daytime server about the current date and time. Daytime runs at TCP port 13 by default. So we could use TCPAsk in the this way:

$ java TCPAsk time.nist.gov 13
time.nist.gov:13 says:

59604 22-01-25 18:03:08 00 0 0 626.1 UTC(NIST) *
The following example uses another Internet protocol, the "whois" protocol, which is for making queries about resources on the Internet. The whois protocol uses port 43. Here we use the third optional argument to TCPAsk to pass a string to the whois server asking for information about the domain name "kth.se".

$ java TCPAsk whois.iis.se 43 kth.se
whois.iis.se:43 says:
...
(The output is quite lengthy, so try this for yourself and check the output!)

Note: TCPAsk is a text application, meaning that it sends encoded text to the server, and decodes the result from the server into text. This makes it easier to use from the command line program, but it also means that we cannot use TCPAsk to communicate with servers that use other data formats than text.
