@ echo off
findstr /v "qwekljsdaiouc" header.txt >> mystockchart.html
for /f "tokens=*" %%a in (header.txt) do (
  echo line=%%a
)
pause