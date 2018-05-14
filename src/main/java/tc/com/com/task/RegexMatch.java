package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/5/14.
 */
public class RegexMatch {


    public boolean match(char[] str, char[] pattern){
        if(null == str || null == pattern){
            return false;
        }

        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int sIndex, int pIndex){
        if(sIndex == str.length && pIndex == pattern.length){
            return true;
        }
        if(sIndex != str.length && pIndex == pattern.length){
            return false;
        }
        if(pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*'){
            if(pattern[pIndex] == str[sIndex] || (pattern[pIndex] == '.' && sIndex < str.length)){
                return matchCore(str, pattern, sIndex + 1, pIndex + 2)
                        || matchCore(str, pattern, sIndex + 1, pIndex)
                        || matchCore(str, pattern, sIndex, pIndex + 2);
            } else {
                return matchCore(str, pattern, sIndex, pIndex + 2);
            }
        }
        if(sIndex >= str.length) return false;
        if(pattern[pIndex] == str[sIndex] || pattern[pIndex] == '.'){
            return matchCore(str, pattern, sIndex + 1, pIndex + 1);
        }

        return false;

    }


    public static void main(String[] args){
        RegexMatch rm =new RegexMatch();
        String a = "abdcabbbc";
        String b = "ab.*bc";

        System.out.println(a.matches(b));
        char[] str = a.toCharArray();
        char[] pattern = b.toCharArray();

        System.out.println(rm.match(str, pattern));

    }



}
