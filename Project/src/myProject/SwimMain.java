package myProject;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

public class SwimMain {
	public static void main(String[] args) throws SQLException {
		SwimDAO swimDao = new SwimDAO();
		Scanner scn = new Scanner(System.in);
		UserManage um = UserManage.getInstance();

		boolean checked = false;
		String userId1 = null;

		// 관리자 로그인
		while (!checked) {
			System.out.printf("ID : ");
			String userId = scn.nextLine();
			System.out.printf("PassWord: ");
			String userPw = scn.nextLine();
			if (swimDao.login(userId, userPw) == 1) { // db에 저장된 아이디와 비밀번호가 일치한다면
				userId1 = userId;
				System.out.println("* 관리자 " + userId + "님 환영합니다! *");
				break;
			} else {
				System.out.println(userId + "는 관리자 계정이 아니므로 접근 불가합니다.");
				continue;
			}
		}

		// 메인메뉴
		while (true) {
			System.out.println("-------------------------------------------");
			System.out.println("1.회원등록 2.회원목록조회 3.회원상세조회(수정) 4.강좌별 회원조회 5.회원삭제 6.강사관리 0.종료");
			System.out.printf("선택 > ");
			int menu = Integer.parseInt(scn.nextLine());

			// 회원등록
			if (menu == 1) {
				System.out.println("< 회원 등록 메뉴로 이동합니다. >");
				String name = Utils.readStr("회원 이름 > ");
				String sex = Utils.readStr("회원 성별 > ");
				String birth = Utils.readStr("회원 생년월일 > ");
				String phoneNum = Utils.readStr("회원 연락처 > ");
				String email = Utils.readStr("회원 이메일 > ");
				String address = Utils.readStr("회원 주소 > ");
				String course = Utils.readStr("등록하는 강좌 > [초급반 / 중급반 / 상급반 / 고급반 / 교정반 / 연수반] ");
				String tName = swimDao.setTea(course); //강좌 등록시 강사 지정
				if (name.equals("quit") || sex.equals("quit") || birth.equals("quit") || phoneNum.equals("quit") // 입력값 중 quit가 있다면
						|| email.equals("quit") || address.equals("quit") || course.equals("quit")) {
					continue; // 다시 메인메뉴로 갑니다
				}
				if (name.equals("") || sex.equals("") || birth.equals("") || phoneNum.equals("") || email.equals("")
						|| address.equals("") || course.equals("")) { // 입력값 중 빈칸이 있다면
					System.out.println("등록되지 않은 값이 있습니다.");
					continue;
				}

				int money = 0; // 강좌 등록시 수강료 자동 지정
				if (course.equals("초급반") || course.equals("중급반") || course.equals("상급반")) {
					money = 50000;
				} else if (course.equals("고급반") || course.equals("교정반")) {
					money = 60000;
				} else if (course.equals("연수반")) {
					money = 65000;
				}

				System.out.println("일반회원이면 1, 할인회원이면 2를 입력하세요.");
				int pay = Integer.parseInt(scn.nextLine());
				if (pay == 1) { // 일반 회원이라면 수강료 유지
				} else if (pay == 2) { // 할인 회원이라면 10퍼센트 할인
					money = (int) (money - (money * 0.1));
				}
				Swim user = new Swim(0, name, sex, birth, phoneNum, email, address, course, money, null, tName);
				swimDao.insert(user);
				System.out.println("신규회원 등록 완료되었습니다.");
			}

			// 회원목록조회
			else if (menu == 2) {
				System.out.println("< 회원 목록 조회 메뉴로 이동합니다. >");
				List<Swim> users = swimDao.listSearch();
				for (Swim sw : users) {
					System.out.println(sw.showInfo());
				}
				System.out.println("조회 완료되었습니다.");
				System.out.printf("파일로 저장을 원하시면 1, 메인메뉴로 돌아가려면 아무 번호나 입력하세요.");
				int file = Integer.parseInt(scn.nextLine());
				if(file==1) {
					um.storeToFile();
					System.out.println("파일로 저장되었습니다.");
				} else {
					System.out.println("메뉴로 돌아갑니다.");
				}
				
			}

			// 회원상세조회
			else if (menu == 3) {
				System.out.println("< 회원 상세 조회 메뉴로 이동합니다. >");
				System.out.printf("조회할 회원 번호 입력하세요. > ");
				int userNo = Integer.parseInt(scn.nextLine());
				Swim s = swimDao.search(userNo);

				if (s != null) { // 조회할 회원번호가 있다면
					if (userNo == s.getUserNo()) {
						System.out.println(s);
						System.out.println("** 정보를 수정하시려면 1, 메인메뉴로 돌아가려면 아무번호나 입력하세요. ** ");
						int choice = Integer.parseInt(scn.nextLine());

						if (choice == 1) {// 수정 메뉴로 이동
							System.out.println("< 회원 수정 메뉴로 이동합니다. >");
							String name = Utils.readStr("회원 이름 > ");
							String sex = Utils.readStr("회원 성별 > ");
							String birth = Utils.readStr("회원 생년월일 > ");
							String phoneNum = Utils.readStr("회원 연락처 > ");
							String email = Utils.readStr("회원 이메일 > ");
							String address = Utils.readStr("회원 주소 > ");
							String course = Utils.readStr("수정할 강좌 [ 초급반 / 중급반 / 상급반 / 고급반 / 교정반 / 연수반 ] > ");
							String tName = swimDao.setTea(course);// 강좌 등록 시 강사이름 자동지정
							if (name.equals("quit") || sex.equals("quit") || birth.equals("quit")
									|| phoneNum.equals("quit") || email.equals("quit") || address.equals("quit")
									|| course.equals("quit")) {
								continue;
							}
							if (name.equals("") || sex.equals("") || birth.equals("") || phoneNum.equals("")
									|| email.equals("") || address.equals("") || course.equals("")) { // 입력값 중 빈칸이 있다면
								System.out.println("등록되지 않은 값이 있습니다.");
								continue;
							}
							int money = 0;
							if (course.equals("초급반") || course.equals("중급반") || course.equals("상급반")) {
								money = 50000;
							} else if (course.equals("고급반") || course.equals("교정반")) {
								money = 60000;
							} else if (course.equals("연수반")) {
								money = 65000;
							}

							System.out.println("일반회원이면 1, 할인회원이면 2를 입력하세요.");
							int pay = Integer.parseInt(scn.nextLine());
							if (pay == 1) { // 일반 회원이라면 수강료 유지
							} else if (pay == 2) { // 할인 회원이라면 10퍼센트 할인
								money = (int) (money - (money * 0.1));
							}

							System.out.printf("수정할 수강등록일 > ");
							String date = scn.nextLine();

							Swim modiUser = new Swim(userNo, name, sex, birth, phoneNum, email, address, course, money,
									date, tName);
							swimDao.update(modiUser);
							System.out.println(userNo + "번 회원정보 수정 완료.");
						} else { // 수정을 원하지 않는다면 메인메뉴로 다시 이동
							continue;
						}
					}
				} else { //조회할 번호가 없다면
					System.out.println("조회할 번호가 없습니다.");
				}
			}

			// 강좌별 회원조회
			else if (menu == 4) {
				System.out.println("< 강좌별 회원 조회 메뉴로 이동합니다 >");
				System.out.printf("조회할 강좌를 입력하세요. [초급반 / 중급반 / 상급반 / 고급반 / 교정반 / 연수반] ");
				String courseName = scn.nextLine();
				List<Swim> list = swimDao.courseSearch(courseName);
				for (Swim sm : list) {
					System.out.println(sm.toString());
				}
			}

			// 회원삭제
			else if (menu == 5) {
				System.out.println("< 회원 삭제 메뉴로 이동합니다 >");
				System.out.printf("삭제할 회원 번호를 입력하세요. > ");
				int userNo = Integer.parseInt(scn.nextLine());
				Swim sm = swimDao.search(userNo);

				if (sm != null) {
					if (userNo == sm.getUserNo()) {
						System.out.printf(
								"입력하신 회원 번호는 " + userNo + "번, 이름은 " + sm.getName() + "입니다. 정말로 삭제하시겠습니까? Y/N > ");
						String msg = scn.nextLine();
						if (msg.equals("Y")) {
							swimDao.delete(userNo);
							System.out.println("회원번호 " + userNo + "번 삭제 완료.");
						} else {
							System.out.println("메인 메뉴로 이동합니다.");
							continue;
						}
					}
				} else {
					System.out.println("회원 번호가 존재하지 않습니다. 메뉴로 돌아갑니다.");
				}
			}
			// 강사 관리
			else if (menu == 6) {
				while (true) {
					System.out.println("< 강사 관리 메뉴로 이동합니다 >");
					System.out.println("-------------------------------------------");
					System.out.println("1.강사 조회 2.강사 상세조회(수정) 3.강사 등록 4.강사 삭제 0.메뉴");
					int tMenu = Integer.parseInt(scn.nextLine());

					if (tMenu == 1) { // 강사 조회
						System.out.println("< 강사 조회 메뉴로 이동합니다. >");
						List<Teacher> teachers = swimDao.tSearchList();
						for (Teacher t : teachers) {
							System.out.println(t.showInfo());
						}
						System.out.println("조회 완료되었습니다.");

					} else if (tMenu == 2) { // 강사 상세조회, 수정
						System.out.println("<강사 상세 조회 메뉴로 이동합니다.>");
						System.out.printf("조회할 강사 번호 입력하세요. > ");
						int tNo = Integer.parseInt(scn.nextLine());
						Teacher t = swimDao.tsearch(tNo);

						if (t != null) { //강사번호가 존재한다면
							if (tNo == t.gettNo()) {
								System.out.println(t);
								System.out.printf("** 정보를 수정하시려면 1, 메인메뉴로 돌아가려면 아무번호나 입력하세요. **");
								int choice = Integer.parseInt(scn.nextLine());
								if (choice == 1) { // 강사정보 수정하려면
									System.out.println("< 강사 수정 메뉴로 이동합니다 >");
									String tName = Utils.readStr("수정할 강사 이름 > ");
									String tId = Utils.readStr("수정할 강사 직책 > ");
									String tPhone = Utils.readStr("수정할 연락처 > ");
									String tCourse = Utils.readStr("수정할 진행 강좌명 > ");
									String hireDate = Utils.readStr("수정할 입사일 > ");
									String licence = Utils.readStr("수정할 자격증 > ");

									if (tName.equals("quit") || tId.equals("quit") || tPhone.equals("quit")
											|| tCourse.equals("quit") || hireDate.equals("quit")
											|| licence.equals("quit")) {
										continue;
									}
									if (tName.equals("") || tId.equals("") || tPhone.equals("") || tCourse.equals("")
											|| hireDate.equals("") || licence.equals("")) { // 입력값 중 빈칸이 있다면
										System.out.println("등록되지 않은 값이 있습니다.");
										continue;
									}
									Teacher modiTeach = new Teacher(tNo, tName, tId, tCourse, hireDate, tPhone,
											licence);
									swimDao.tUpdate(modiTeach);
									System.out.println(tNo + "번 강사정보 수정 완료.");
								} else { // 아무번호나 눌러서 다시 메인메뉴로 이동
									continue;
								}
							}
						} else { // 강사번호를 입력했지만 존재하지 않을때
							System.out.println("조회할 강사번호가 존재하지 않습니다.");
							continue;
						}
					} else if (tMenu == 3) { // 강사 등록
						System.out.println("< 강사 등록 메뉴로 이동합니다. >");
						String tName = Utils.readStr("이름 > ");
						String tId = Utils.readStr("직책 > ");
						String tPhone = Utils.readStr("연락처 > ");
						String tCourse = Utils.readStr("진행 강좌명 > ");
						String hireDate = Utils.readStr("입사일 > ");
						String licence = Utils.readStr("등록할 자격증 > ");

						if (tName.equals("quit") || tId.equals("quit") || tPhone.equals("quit")
								|| tCourse.equals("quit") || hireDate.equals("quit") || licence.equals("quit")) {
							continue;
						}
						if (tName.equals("") || tId.equals("") || tPhone.equals("") || tCourse.equals("")
								|| hireDate.equals("") || licence.equals("")) { // 입력값 중 빈칸이 있다면
							System.out.println("등록되지 않은 값이 있습니다.");
							continue;
						}
						Teacher t = new Teacher(0, tName, tId, tCourse, hireDate, tPhone, licence);
						swimDao.tInsert(t);
					} else if (tMenu == 4) { // 강사 삭제
						System.out.println("< 강사 삭제 메뉴로 이동합니다 >");
						System.out.printf("삭제할 강사 번호를 입력하세요. >");
						int tNo = Integer.parseInt(scn.nextLine());
						Teacher t = swimDao.tsearch(tNo);

						if (t != null) {
							if (tNo == t.gettNo()) {
								System.out.println(
										"입력하신 강사 번호는 " + tNo + "번, 이름은 " + t.getName() + "입니다. 정말로 삭제하시겠습니까? Y/N");
								String msg = scn.nextLine();
								if (msg.equals("Y")) {
									swimDao.tDelete(tNo);
									System.out.println("강사번호 " + tNo + "번 삭제 완료.");
								} else {
									System.out.println("메인 메뉴로 이동합니다.");
									continue;
								}
							}
						} else {
							System.out.println("강사 번호가 존재하지 않습니다. 메뉴로 돌아갑니다.");
						}
					} else if (tMenu == 0) { //메뉴 선택
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					}
				}
			} //end of teacherMain
			// 프로그램 종료.
			else if (menu == 0) {
				System.out.println("회원관리 프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		} //end of while.
		scn.close();
		System.out.println("프로그램 종료.");
	} //end of main.
} 
