namespace AdventOfCode;

class Program
{
    static void Main(string[] args)
    {
        RowAnalyzer analyzer = new RowAnalyzer();
        int count = 0;
        int foundCount = 0;
        List<string> notFound = new List<string>();

        Test.TestAll();

        var list = File.ReadAllLines(@"values.txt");
        list = list.Select(x => x.Trim().ToLower()).ToArray();

        foreach (string row in list)
        {
            int? value = analyzer.Analyze(row);
            if (value is not null) 
                foundCount ++;
            else
                notFound.Add(row);

            count += value ?? 0;
        }

        Console.WriteLine("------------------------------------------");
        Console.WriteLine("Count: " + count);
        Console.WriteLine("Found: " + foundCount);
        Console.WriteLine("Total: " + list.Length);
        Console.WriteLine("------------------------------------------");
        Console.WriteLine(string.Join("\n", notFound));
    }
}