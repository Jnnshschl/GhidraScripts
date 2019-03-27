# GhidraScripts

Here is my collection of Ghidra scripts. Things should be pretty self explaining.

https://ghidra-sre.org

# Current Scripts

## ImportFunctionNames.java

This script does one simple thing, it reads a file containing the FunctionOffset and the FunctionName and will rename all functions in Ghidra to their name specified in the file.

Example File;
```
007225E0;FrameScript__GetLocalizedText
00819210;FrameScript__Execute
... 
```

The function at 0x7225E0 will be renamed to "FrameScript__GetLocalizedText" and so on. 
