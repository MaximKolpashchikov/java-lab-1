package common;

public enum Colour
{
    RESET("\033[0m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    MAGENTA("\033[35m"),
    CYAN("\033[36m"),
    WHITE("\033[37m");

    private final String _code;

    Colour(String code)
    {
        _code = code;
    }

    public String toString()
    {
        return _code;
    }
}