  1. Make sure you have Java5 or higher.
  1. Download it from http://code.google.com/p/javasupport/wiki/DownloadsHome
  1. Unzip it to `/opt/javasupport` (Unix) or `C:\opt\ javasupport ` (Windows)
  1. Add `/opt/javasupport/bin` to PATH  of your OS system environment variable

NOTE: You may install the javasupport to any directory, but if you install to a path that contains SPACE, the run script will FAIL!!! Space in a path name is very evil, especially in Windows, so avoid it like a plague at all time.

# To verify installation #

On Unix/Linux
```
$ template.sh --help
```

On Windows
```
C:> template --help
```