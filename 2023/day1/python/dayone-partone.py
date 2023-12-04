def retrievedigits(thislist):
  digits = ""
  enum=["one","two","three","four","five","six","seven","eight","nine"]
  #find the digits in the line
  for x in thislist:
    if x.isdigit():
      digits+=x
  number=[digits[0],digits[(len(digits))-1]]
  return number

f = open("list.txt", "r")
sumof=0
#for every line, call the function and sum the result
for x in f:
  num = int(''.join(map(str,retrievedigits(x))))
  sumof+=num

print(sumof)
