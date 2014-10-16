package JavaPattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 �ַ�	����
/	����һ���ַ����Ϊһ�������ַ�����һ��ԭ���ַ�����һ�� �������á���һ���˽���ת��������磬'n' ƥ���ַ� "n"��'/n' ƥ��һ�����з������� '//' ƥ�� "/" �� "/(" ��ƥ�� "("��
^	ƥ�������ַ����Ŀ�ʼλ�á���������� RegExp ����� Multiline ���ԣ�^ Ҳƥ�� '/n' �� '/r' ֮���λ�á�
$	ƥ�������ַ����Ľ���λ�á����������RegExp ����� Multiline ���ԣ�$ Ҳƥ�� '/n' �� '/r' ֮ǰ��λ�á�
*	ƥ��ǰ����ӱ��ʽ��λ��Ρ����磬zo* ��ƥ�� "z" �Լ� "zoo"�� * �ȼ���{0,}��
+	ƥ��ǰ����ӱ��ʽһ�λ��Ρ����磬'zo+' ��ƥ�� "zo" �Լ� "zoo"��������ƥ�� "z"��+ �ȼ��� {1,}��
?	ƥ��ǰ����ӱ��ʽ��λ�һ�Ρ����磬"do(es)?" ����ƥ�� "do" �� "does" �е�"do" ��? �ȼ��� {0,1}��
{n}	n ��һ���Ǹ�������ƥ��ȷ���� n �Ρ����磬'o{2}' ����ƥ�� "Bob" �е� 'o'��������ƥ�� "food" �е����� o��
{n,}	n ��һ���Ǹ�����������ƥ��n �Ρ����磬'o{2,}' ����ƥ�� "Bob" �е� 'o'������ƥ�� "foooood" �е����� o��'o{1,}' �ȼ��� 'o+'��'o{0,}' ��ȼ��� 'o*'��
{n,m}	m �� n ��Ϊ�Ǹ�����������n <= m������ƥ�� n �������ƥ�� m �Ρ����� "o{1,3}" ��ƥ�� "fooooood" �е�ǰ���� o��'o{0,1}' �ȼ��� 'o?'����ע���ڶ��ź�������֮�䲻���пո�
?	�����ַ��������κ�һ���������Ʒ� (*, +, ?, {n}, {n,}, {n,m}) ����ʱ��ƥ��ģʽ�Ƿ�̰���ġ���̰��ģʽ�������ٵ�ƥ�����������ַ�������Ĭ�ϵ�̰��ģʽ�򾡿��ܶ��ƥ�����������ַ��������磬�����ַ��� "oooo"��'o+?' ��ƥ�䵥�� "o"���� 'o+' ��ƥ������ 'o'��
.	ƥ��� "/n" ֮����κε����ַ���Ҫƥ����� '/n' ���ڵ��κ��ַ�����ʹ���� '[./n]' ��ģʽ��
(pattern)	ƥ��pattern ����ȡ��һƥ�䡣����ȡ��ƥ����ԴӲ����� Matches ���ϵõ�����VBScript ��ʹ�� SubMatches ���ϣ���JScript ����ʹ�� $0��$9 ���ԡ�Ҫƥ��Բ�����ַ�����ʹ�� '/(' �� '/)'��
(?:pattern)	ƥ�� pattern ������ȡƥ������Ҳ����˵����һ���ǻ�ȡƥ�䣬�����д洢���Ժ�ʹ�á�����ʹ�� "��" �ַ� (|) �����һ��ģʽ�ĸ��������Ǻ����á����磬 'industr(?:y|ies) ����һ���� 'industry|industries' �����Եı��ʽ��
(?=pattern)	����Ԥ�飬���κ�ƥ�� pattern ���ַ�����ʼ��ƥ������ַ���������һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á����磬 'Windows (?=95|98|NT|2000)' ��ƥ�� "Windows 2000" �е� "Windows" ��������ƥ�� "Windows 3.1" �е� "Windows"��Ԥ�鲻�����ַ���Ҳ����˵����һ��ƥ�䷢���������һ��ƥ��֮��������ʼ��һ��ƥ��������������ǴӰ���Ԥ����ַ�֮��ʼ��
(?!pattern)	����Ԥ�飬���κβ�ƥ��Negative lookahead matches the search string at any point where a string not matching pattern ���ַ�����ʼ��ƥ������ַ���������һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á�����'Windows (?!95|98|NT|2000)' ��ƥ�� "Windows 3.1" �е� "Windows"��������ƥ�� "Windows 2000" �е� "Windows"��Ԥ�鲻�����ַ���Ҳ����˵����һ��ƥ�䷢���������һ��ƥ��֮��������ʼ��һ��ƥ��������������ǴӰ���Ԥ����ַ�֮��ʼ
x|y	ƥ�� x �� y�����磬'z|food' ��ƥ�� "z" �� "food"��'(z|f)ood' ��ƥ�� "zood" �� "food"��
[xyz]	�ַ����ϡ�ƥ��������������һ���ַ������磬 '[abc]' ����ƥ�� "plain" �е� 'a'��
[^xyz]	��ֵ�ַ����ϡ�ƥ��δ�����������ַ������磬 '[^abc]' ����ƥ�� "plain" �е�'p'��
[a-z]	�ַ���Χ��ƥ��ָ����Χ�ڵ������ַ������磬'[a-z]' ����ƥ�� 'a' �� 'z' ��Χ�ڵ�����Сд��ĸ�ַ���
[^a-z]	��ֵ�ַ���Χ��ƥ���κβ���ָ����Χ�ڵ������ַ������磬'[^a-z]' ����ƥ���κβ��� 'a' �� 'z' ��Χ�ڵ������ַ���
/b	ƥ��һ�����ʱ߽磬Ҳ����ָ���ʺͿո���λ�á����磬 'er/b' ����ƥ��"never" �е� 'er'��������ƥ�� "verb" �е� 'er'��
/B	ƥ��ǵ��ʱ߽硣'er/B' ��ƥ�� "verb" �е� 'er'��������ƥ�� "never" �е� 'er'��
/cx	ƥ����xָ���Ŀ����ַ������磬 /cM ƥ��һ�� Control-M ��س����� x ��ֵ����Ϊ A-Z �� a-z ֮һ�����򣬽� c ��Ϊһ��ԭ��� 'c' �ַ���
/d	ƥ��һ�������ַ����ȼ��� [0-9]��
/D	ƥ��һ���������ַ����ȼ��� [^0-9]��
/f	ƥ��һ����ҳ�����ȼ��� /x0c �� /cL��
/n	ƥ��һ�����з����ȼ��� /x0a �� /cJ��
/r	ƥ��һ���س������ȼ��� /x0d �� /cM��
/s	ƥ���κοհ��ַ��������ո��Ʊ������ҳ���ȵȡ��ȼ��� [ /f/n/r/t/v]��
/S	ƥ���κηǿհ��ַ����ȼ��� [^ /f/n/r/t/v]��
/t	ƥ��һ���Ʊ�����ȼ��� /x09 �� /cI��
/v	ƥ��һ����ֱ�Ʊ�����ȼ��� /x0b �� /cK��
/w	ƥ������»��ߵ��κε����ַ����ȼ���'[A-Za-z0-9_]'��
/W	ƥ���κηǵ����ַ����ȼ��� '[^A-Za-z0-9_]'��
/xn	ƥ�� n������ n Ϊʮ������ת��ֵ��ʮ������ת��ֵ����Ϊȷ�����������ֳ������磬 '/x41' ƥ�� "A"��'/x041' ��ȼ��� '/x04' & "1"��������ʽ�п���ʹ�� ASCII ���롣.
/num	ƥ�� num������ num ��һ����������������ȡ��ƥ������á����磬'(.)/1' ƥ��������������ͬ�ַ���
/n	��ʶһ���˽���ת��ֵ��һ���������á���� /n ֮ǰ���� n ����ȡ���ӱ��ʽ���� n Ϊ�������á�������� n Ϊ�˽������� (0-7)���� n Ϊһ���˽���ת��ֵ��
/nm	��ʶһ���˽���ת��ֵ��һ���������á���� /nm ֮ǰ������is preceded by at least nm ����ȡ���ӱ��ʽ���� nm Ϊ�������á���� /nm ֮ǰ������ n ����ȡ���� n Ϊһ��������� m �ĺ������á����ǰ��������������㣬��  n �� m ��Ϊ�˽������� (0-7)���� /nm ��ƥ��˽���ת��ֵ nm��
/nml	��� n Ϊ�˽������� (0-3)���� m �� l ��Ϊ�˽������� (0-7)����ƥ��˽���ת��ֵ nml��
/un	ƥ�� n������ n ��һ�����ĸ�ʮ���������ֱ�ʾ�� Unicode �ַ������磬 /u00A9 ƥ���Ȩ���� (?)��
 * */

public class NewPattern {
	public static void main(String[] args) {
		NewPattern new1=  new NewPattern();
//		new1.usePattern1();
//		new1.useMatcher1();
		new1.useMatcher2();
	}
	
	public void usePattern1(){
		Pattern  p = Pattern.compile("[+-]");
		String[] results = p.split("hellowold+woshi ni - hhe");
		System.out.println(Arrays.deepToString(results));
	}
	
	public void usePattern2(){
		
	}
	
	public void useMatcher1(){
		// ̰��ƥ��
		/*̰��ģʽ���������ʽƥ��ɹ���ǰ���£������ܶ��ƥ�䣬����̰��ģʽ���������ʽƥ��ɹ���ǰ���£��������ٵ�ƥ��*/
//		Pattern p = Pattern.compile("f(.+)k");
		Pattern p = Pattern.compile("f(.+?)k");
		String str = "fckfukkfkf";
		Matcher m = p.matcher(str);
		
		while(m.find()){
			String s0 = m.group();
			// �ڶ�����������Ķ���
//			String s1 = m.group(1);
//			String s2 = m.group(2);
//			System.out.println(s0 + "||"+s1);
			System.out.println(s0);
			
//			System.out.println(m.start(0)+  "  "+m.end(0));
//			System.out.println(m.start(1)+  "  "+m.end(1));
//			System.out.println(m.start(2)+  "  "+m.end(2));
			
//			System.out.println(str.substring(m.start(0),m.end(0)));
		}
	}
	
	public void useMatcher2(){	
		List<Integer> numbers = new LinkedList<Integer>();
//		Pattern p = Pattern.compile("\\d{2,}");
//		Pattern p = Pattern.compile("\\d+");// �� "\\d{1��}" �ȼ�
//		Pattern p = Pattern.compile("\\d{1,3}");
		
		// 12sa �� 123e ���ᱻƥ�䵽
		//  'industr(?:y|ies) ����һ���� 'industry|industries' �����Եı��ʽ��
//		Pattern p = Pattern.compile("12(?:sa|3e)");
		
		// ����Ԥ��,��� 12 �� 12sa�����12
//		Pattern p = Pattern.compile("12(?=sa)");
//		String str = "12sbc34ssd1123ee1"; //����Ԥ���������

		// ����Ԥ�飬���� 12sa�Ͳ�ƥ��
//		Pattern p = Pattern.compile("12(?!sa)");
//		String str = "12sabc34ssd113ee1"; // ����Ԥ������
		
//		Pattern p = Pattern.compile("12(sa|3e)");
		
//		Pattern p = Pattern.compile("[^abc]"); // �ַ�����/��ֵ�ַ�����
		
		Pattern p = Pattern.compile("ab");
		
		String str = "12sab34ssd1123ee1"; // ��������
		Matcher m = p.matcher(str); 
		
		// String �� ���� replaceAll��ʵ�֣�������replace ����  Pattern.compile(target.toString(), Pattern.LITERAL) 
		// ������ ����ֵģʽ��replaceֻ����ʹ������ֵ��replaceAll ����ʹ��������ʽ
		System.out.println(m.replaceAll("��"));
		String replacement = "��";
		System.out.println(str.replaceAll("12(sa|3e)", replacement));
//		while (m.find()) {
//		  numbers.add(Integer.parseInt(m.group()));
//			String s0 = m.group();
//			System.out.println(s0);
//		}
//		System.out.println(numbers);
	}
}
