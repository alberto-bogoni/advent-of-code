def retrievedigits(thislist):
  digits = ""
  enum=["one","two","three","four","five","six","seven","eight","nine"]
  number=[]
  positions={}
  
  for x in thislist:
    if x.isdigit():
      for y in range(thislist.count(x)):
        positions[[i for i, z in enumerate(thislist) if z == x][y]] = x  
  
  for x in enum:
    for y in range(thislist.count(x)):
      if x in thislist:
        print([i for i, z in enumerate(thislist) if z == x][y])

  sorted_dict = dict(sorted(positions.items()))

  if (list(sorted_dict.values())[0]).isdigit():
    number.append(list(sorted_dict.values())[0])
  else:
    number.append((enum.index(list(sorted_dict.values())[0]))+1)
  
  if (list(sorted_dict.values())[len(sorted_dict.values())-1]).isdigit():
    number.append(list(sorted_dict.values())[len(sorted_dict.values())-1])
  else:
    number.append((enum.index(list(sorted_dict.values())[len(sorted_dict.values())-1]))+1)
  #create and return an array with the first and the last digit of a line

  return number

f = open("C:/Users/tomir/Documents/GitHub/advent-of-code/2023/day1/python/values.txt", "r")
sumof=0
#for every line, call the function and sum the result
for x in f:
  num = int(''.join(map(str,retrievedigits(x))))
  sumof+=num

print(sumof)


