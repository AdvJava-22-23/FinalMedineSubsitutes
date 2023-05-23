import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class herbalConfirm
{
    private static final String HERBAL_REMEDIES_REGEX_FILE = "herbal_remedies_regex.regex";

    private Pattern herbalRemedyPattern;

    public herbalConfirm()
    {
        herbalRemedyPattern = loadRegexPattern(HERBAL_REMEDIES_REGEX_FILE);
    }

    private Pattern loadRegexPattern(String fileName)
    {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null)
        {
            throw new RuntimeException("Failed to load regex file: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
        {
            StringBuilder regexBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                regexBuilder.append(line);
            }
            return Pattern.compile(regexBuilder.toString());
        } catch (IOException e) //again with the catch because I love it when my code doesn't break
        {
            throw new RuntimeException("it broke and not because of me!: " + fileName, e);
        }
    }

    public boolean isValidHerbalRemedy(String remedyName)
    {
        return herbalRemedyPattern.matcher(remedyName).matches();
    }
}