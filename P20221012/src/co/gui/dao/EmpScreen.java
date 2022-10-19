package co.gui.dao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmpScreen extends JFrame implements ActionListener, MouseListener {

	// 입력항목을 처리하기 위한 컴포넌트
	private String[] labels = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
	private JTextField[] fields = new JTextField[6];

	// 컴포넌트를 배치하기 위한 컨테이너
	private JPanel topPanel;
	private JScrollPane centerPanel; // 스크롤 담당
	private JPanel rightPanel; // 오른쪽에 버튼

	// 데이터를 담기 위한 jTable
	private JTable table; // 데이터 목록을 테이블형식으로 보여주는.

	// 이벤트를 발생시키기 위한 버튼.
	private JButton addBtn, delBtn, findBtn, initBtn;

	EmpDAO dao = new EmpDAO();
	List<EmployeeVO> list;

	public EmpScreen() {
		setTitle("사원정보 관리화면");
		setLayout(new BorderLayout(10, 10)); // 숫자넣으면 여백

		// topPanel 추가
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i])); // 반복문으로
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		// centerPanel 추가
		String[] headers = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(this); //마우스의 이벤트
		centerPanel = new JScrollPane(table);

		// 오른쪽 버튼.
		rightPanel = new JPanel(new GridLayout(4, 1)); // 기본값으로 지정
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");
		// 버튼 누르면 액션 되도록!
		// 매개값으로 익명구현객체가 와도 되고.. 이 클래스 자체를 actionListener을 구현해주는 걸로 만들어버리면 된다!
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);

		add("North", topPanel); // 위의 입력항목들 배치.
		add("Center", centerPanel); // 센터패널은 가운데에.
		add("East", rightPanel);

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	} // end of EmpScreen()

	// DB조회 후 table에다가 결과를 반영.
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] record = new String[6];
		list = dao.empList(new EmployeeVO(0, null, null, null, null, null)); //0과 null로 매개값을 준다면 모든결과를 조회한다는 뜻
		for(int i=0; i<list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getEmployeeId()); //리스트만큼 반복해서 사원번호를 넣어줌
			record[1] = list.get(i).getFirstName();
			record[2] = list.get(i).getLastName();
			record[3] = list.get(i).getEmail();
			record[4] = list.get(i).getHireDate();
			record[5] = list.get(i).getJobId();
			model.addRow(record);
		}

	}

	@Override // actionListener를 구현하기 위한 메소드.
	public void actionPerformed(ActionEvent e) {
		// addBtn, delBtn, findBtn, initBtn 중 어느것이 눌러졌는지 ...
		Object src = e.getSource(); // 이벤트가 발생한게 어디인지를 반환해줌

		if (src == addBtn) {

		} else if (src == delBtn) {

		} else if (src == findBtn) {
			searchData();
		} else if (src == initBtn) {

		}
	} // end of actionPerformed(ActionEvent e)
	
	//마우스 이벤트 처리(클릭). 
	@Override
	public void mouseClicked(MouseEvent e) {
		//table을 클릭했을때 처리해주는 기능들..
		int selectedRow = table.getSelectedRow(); //선택된 row를 반환.
		
		DefaultTableModel model = (DefaultTableModel) table.getModel(); //테이블에서 선택된걸 찾아옴
		System.out.println(model.getValueAt(selectedRow,0)); //선택되어진 인덱스값으로 0번째에 있는 값을 가져옴 
		int empId = Integer.parseInt((String) model.getValueAt(selectedRow,0)); //사원번호!
		
		dao.deleteEmp(empId);
		
	}

	// 프로그램의 시작.
	public static void main(String[] args) {
		new EmpScreen();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

} // end of class.
