@ echo off
findstr /v "qwekljsdaiouc" header.txt >> mysetting.xml
for /f "tokens=*" %%a in (header.txt) do (
  echo line=%%a
)
echo ABT.csv  >> mysetting.xml
findstr /v "qwekljsdaiouc" footer.txt >> mysetting.xml
for /f "tokens=*" %%a in (header.txt) do (
  echo line=%%a
)
pause