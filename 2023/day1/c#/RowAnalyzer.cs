namespace AdventOfCode;

public class RowAnalyzer 
{
    private int left = 0, right;
    private char? leftCurrent = null, rightCurrent = null;

    private static readonly Dictionary<string, char> digitsChars = new Dictionary<string, char>() 
    { 
        {"one", '1'}, 
        {"two", '2'}, 
        {"three", '3'}, 
        {"four", '4'}, 
        {"five", '5'}, 
        {"six", '6'}, 
        {"seven", '7'}, 
        {"eight", '8'}, 
        {"nine", '9'} 
    };

    public int? Analyze(string row) 
    {
        SetUp(row.Length);

        for (int i = 0, j = row.Length -1; i < row.Length; i ++, j --)
        {
            if (leftCurrent == null)
            {
                if (Char.IsDigit(row[i]))
                    leftCurrent = row[i];
                else if (digitsChars.Keys.Any(x => row[left..(i+1)].Contains(x)))
                    leftCurrent = digitsChars[digitsChars.Keys.First(x => row[left..(i+1)].Contains(x))];
            }

            if (rightCurrent == null)
            {
                if (Char.IsDigit(row[j]))
                    rightCurrent = row[j];
                else if (digitsChars.Keys.Any(x => row.Substring(j, right-j + 1).Contains(x)))
                    rightCurrent = digitsChars[digitsChars.Keys.First(x => row.Substring(j, right-j + 1).Contains(x))];
            }

            if (leftCurrent is not null && rightCurrent is not null)
                break;
        }
            
        if (leftCurrent is not null || rightCurrent is not null)
        {
            string toParse = $"{leftCurrent}{rightCurrent}";
            if (toParse.Length == 1)
                toParse += toParse;        
            return int.Parse(toParse);
        }

        return null;
    }

    private void SetUp(int length)
    {
        right = length -1;
        leftCurrent = null;
        rightCurrent = null;
    }
}