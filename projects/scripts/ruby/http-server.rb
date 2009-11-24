require 'webrick'
include WEBrick
s = HTTPServer.new(
  :Port            => 2000,
  :DocumentRoot    => Dir::pwd
)

## mount subdirectories
#s.mount("/ipr", HTTPServlet::FileHandler, "/proj/ipr/public_html")
#s.mount("/~gotoyuzo",
#        HTTPServlet::FileHandler, "/home/gotoyuzo/public_html",
#        true)  #<= allow to show directory index.

trap("INT"){ s.shutdown }
s.start
