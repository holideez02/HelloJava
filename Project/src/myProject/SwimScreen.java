package myProject;

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

public class SwimScreen extends JFrame implements MouseListener, ActionListener {

	private String[] labels = { "회원번호", "회원이름", "성별", "생년월일", "연락처", "이메일", "주소", "강좌", "수강료", "수강등록일", "강사이름" };
	private JTextField[] fields = new JTextField[11];

	private JPanel topPanel;
	private JScrollPane centerPanel; // 스크롤 담당
	private JPanel rightPanel; // 오른쪽에 버튼

	private JTable table;

	private JButton addBtn, delBtn, findBtn, initBtn, teacherBtn;

	SwimDAO dao = new SwimDAO();
	List<Swim> list;
	List<Teacher> teacher;
	List<Course> course;

	public SwimScreen() {
		setTitle("수영장 회원정보 관리 화면");
		setLayout(new BorderLayout(10, 10));

		// topPanel 추가
		topPanel = new JPanel(new GridLayout(11, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i])); // 반복문으로
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}

		// centerPanel 추가
		String[] headers = { "회원번호", "회원이름", "성별", "생년월일", "연락처", "이메일", 
						"주소", "강좌", "수강료", "수강등록일", "강사이름" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);

		// 오른쪽 버튼.
		rightPanel = new JPanel(new GridLayout(5, 1));
		addBtn = new JButton("회원 추가");
		delBtn = new JButton("회원 삭제");
		findBtn = new JButton("회원목록 조회");
		teacherBtn = new JButton("강사 조회");
		initBtn = new JButton("초기화");

		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		teacherBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(teacherBtn);
		rightPanel.add(initBtn);

		add("North", topPanel); // 위의 입력항목들 배치.
		add("Center", centerPanel); // 센터패널은 가운데에.
		add("East", rightPanel);

		setSize(1100, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	} // end of SwimScreen()

	// 등록 메소드
	public void addData() {
		String[] records = new String[11];

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < fields.length; i++) {
			records[i] = fields[i].getText();
		}

		Swim sm = new Swim(0, records[1], records[2], records[3], records[4], records[5]);
		dao.insert(sm);
		records[0] = String.valueOf(sm.getUserNo()); // int 타입을 string 으로 변경

		model.addRow(records);

	}

	// 조회 메소드
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int allCnt = model.getRowCount();
		for (int i = 0; i < allCnt; i++) {
			model.removeRow(0);
		}

		String[] record = new String[11];
		int money = 0;
		try {
		 money = Integer.parseInt(fields[8].getText());
		} catch(Exception e) {
			money = 0;
		}
		list = dao.swimList(new Swim(0, fields[1].getText(), fields[2].getText(), 
				fields[3].getText(), fields[4].getText(), fields[5].getText(), 
				fields[6].getText(),fields[7].getText(), 0, 
				fields[9].getText(), fields[10].getText()));

		for (int i = 0; i < list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getUserNo());
			record[1] = list.get(i).getName();
			record[2] = list.get(i).getSex();
			record[3] = list.get(i).getBirth();
			record[4] = list.get(i).getPhoneNum();
			record[5] = list.get(i).getEmail();
			record[6] = list.get(i).getAddress();
			record[7] = list.get(i).getCourse();
			record[8] = String.valueOf(list.get(i).getMoney());
			record[9] = list.get(i).getDate();
			record[10] = list.get(i).gettName();
			model.addRow(record);
		}
	}

	// 삭제 메소드
	public void removeData() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int userNo = Integer.parseInt((String) model.getValueAt(selectedRow, 0));

		dao.delete(userNo);

		model.removeRow(selectedRow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource(); // 이벤트가 발생한게 어디인지를 반환해줌

		if (src == addBtn) {
			addData();
		} else if (src == delBtn) { // delBtn을 눌렀다면
			removeData();
		} else if (src == findBtn) {
			searchData();
		} else if (src == initBtn) {

		}
	}

	public static void main(String[] args) {
		new SwimScreen();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

}
