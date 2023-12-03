
namespace AdventOfCode;

public static class Test 
{
    private static readonly RowAnalyzer analyzer = new();

    public static void TestAll()
    {
        TwoDigits_ShouldReturnThem(); //44
        OneDigit_ShouldReturnItDoubled(); //3
        TwoWords_ShouldReturnThem(); //fourthree
        TwoDigitsAfterPadding_ShouldReturnThem(); //as3dd3as
        OneWord_ShouldReturnItDoubled(); //four
        OneEightOnTheLeft_ShouldReturnOne(); //oneight3
        OneEightOnTheRight_ShouldReturnEight(); //3oneight
        NoNumbers_SholdReturnNull(); //asdfasdfads

        RandomTest_ShouldBeEqualTo("53dhphzvhnknt65ninefive", 55);
    }

    private static void RandomTest_ShouldBeEqualTo(string row, int rightNumber)
    {
        int? value = analyzer.Analyze(row);

        if (value != rightNumber)
            throw new Exception($"RandomTest_ShouldBeEqualTo: {row}");
    }

    private static void NoNumbers_SholdReturnNull()
    {
        string row = "asdfasdfasdf";
        int? value = analyzer.Analyze(row);

        if (value != null)
            throw new Exception("NoNumbers_SholdReturnNull");
    }

    public static void TwoDigits_ShouldReturnThem()
    {
        string row = "45";
        int? value = analyzer.Analyze(row);

        if (value != 45)
            throw new Exception("TwoDigits_ShouldReturnThem");
    }

    public static void OneDigit_ShouldReturnItDoubled()
    {
        string row = "4";
        int? value = analyzer.Analyze(row);

        if (value != 44)
            throw new Exception("OneDigit_ShouldReturnItDoubled");
    }

    public static void OneWord_ShouldReturnItDoubled()
    {
        string row = "nine";
        int? value = analyzer.Analyze(row);

        if (value != 99)
            throw new Exception("OneWord_ShouldReturnItDoubled");
    }

    public static void TwoWords_ShouldReturnThem()
    {
        string row = "twofour";
        int? value = analyzer.Analyze(row);

        if (value != 24)
            throw new Exception("TwoWords_ShouldReturnThem");
    }

    public static void TwoDigitsAfterPadding_ShouldReturnThem()
    {
        string row = "asas5adsasda2fds";
        int? value = analyzer.Analyze(row);

        if (value != 52)
            throw new Exception("TwoDigitsAfterPadding_ShouldReturnThem");
    }

    public static void TwoWordsAfterPadding_ShouldReturnThem()
    { 
        string row = "asasfouradsasdathreefds";
        int? value = analyzer.Analyze(row);

        if (value != 43)
            throw new Exception("TwoWordsAfterPadding_ShouldReturnThem");
    }

    public static void OneEightOnTheLeft_ShouldReturnOne()
    { 
        string row = "asasoneightadsasda1fds";
        int? value = analyzer.Analyze(row);

        if (value != 11)
            throw new Exception("OneEightOnTheLeft_ShouldReturnOne"); 
    }

    public static void OneEightOnTheRight_ShouldReturnEight()
    { 
        string row = "asas1adsasdaoneightfds";
        int? value = analyzer.Analyze(row);

        if (value != 18)
            throw new Exception("OneEightOnTheLeft_ShouldReturnOne");
    }
};