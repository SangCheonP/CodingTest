import java.net.*;
import java.io.*;

public class B0008_1133067 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON08_PARKSANGCHEON";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	
	// 공의 반지름
	static final int R = 3;

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;
		boolean[] isTarget = new boolean[6];
		
		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				
				// 목표공 체크
				// idx 1 ~ 5번까지만 사용
				// 선공
				if(order == 1) {
					for(int i = 1; i < 6; i++) {
						if(i == 1 || i == 3 || i == 5) {
							if(balls[i][0] != -1 && balls[i][1] != 1)
								isTarget[i] = true;
						}
					}
				// 후공
				}else {
					for(int i = 1; i < 6; i++) {
						if(i == 2 || i == 4 || i == 5) {
							if(balls[i][0] != -1 && balls[i][1] != 1)
								isTarget[i] = true;
						}
					}
				}

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				
				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				// target인 공을 순서대로 택하여 하나씩 치도록 함
				float targetBall_x = 0f;
				float targetBall_y = 0f;
				
				// 목적공 선택했는지
				boolean choice = false;
				for(int i = 1; i < 6; i++) {
					if(isTarget[i] && balls[i][0] != -1 && balls[i][1] != -1) {
						System.out.println("target: " + i);
						targetBall_x = balls[i][0];
						targetBall_y = balls[i][1];
						choice = true;
					}
					if(choice)
						break;
				}
				
				System.out.println("targetx: " + targetBall_x);
				System.out.println("targety: " + targetBall_y);
				System.out.println("whitex: " + whiteBall_x);
				System.out.println("whitey: " + whiteBall_y);
				
				for(int i = 1; i < 6; i++) {
					System.out.println("ball" + i + ": " + isTarget[i]);
				}
			
				
				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y)
				{
					System.out.println("3사분면");
					// 목적구가 흰 공과 홀을 이은 선을 기준으로 안: 1, 밖: 2, 일치하면: 3 
					int inout = checkInOut3(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 0);
					if(inout == 1) {
						angle = (float) getDegreeIn3(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 0) + 180;
					}else if (inout == 2) {
						angle = (float) getDegreeOut3(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 0) + 180;
					}else {
						angle = 225;
					}
					System.out.println("angle: " + angle);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산 - OK
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y)
				{
					System.out.println("4사분면");
					int inout = checkInOut1(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 0);
					if(inout == 1) {
						angle = (float) getDegreeIn4(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 0) + 90;
					}else if (inout == 2) {
						angle = (float) getDegreeOut4(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 0) + 90;
					}else {
						angle = 135;
					}
					System.out.println("angle: " + angle);
				}
				
				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y)
				{
					System.out.println("2사분면");
					int inout = checkInOut1(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 127);
					if(inout == 1) {
						angle = (float) getDegreeIn2(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 127) + 270;
					}else if (inout == 2) {
						angle = (float) getDegreeOut2(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 0, 127) + 270;
					}else {
						angle = 315;
					}
					System.out.println("angle: " + angle);
				}
				
				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산 - OK
				else
				{
					System.out.println("1사분면");
					int inout = checkInOut1(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 127);
					if(inout == 1) {
						angle = (float) getDegreeIn1(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 127);
					}else if (inout == 2) {
						angle = (float) getDegreeOut1(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, 254, 127);
					}else {
						angle = 45;
					}
					System.out.println("angle: " + angle);
				}
				
				power = (float) 100;

				





				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 목적구가 흰 공과 홀을 연결한 선보다 안인지 밖인지 체크
	// In: 1, Out: 2, 홀과 흰 공, 목적구가 일직선 상: 3
	public static int checkInOut1(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double wDegree = Math.atan((w_y - R) / (w_x - R));
		double tDegree = Math.atan(((w_y - R) - t_y) / ((w_x - R) - t_x));
		// 
		if(wDegree > tDegree)
			return 1;
		else if(wDegree < tDegree)
			return 2;
		return 3;
	}

	public static int checkInOut4(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double wDegree = Math.atan(((h_x - R) - w_x) / (w_y - R));
		double tDegree = Math.atan(((h_x - R) - t_x) / (t_y - R));
		//
		if(wDegree > tDegree)
			return 1;
		else if(wDegree < tDegree)
			return 2;
		return 3;
	}

	public static int checkInOut3(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double wDegree = Math.atan(((h_x - R) - w_x) / (w_y - R));
		double tDegree = Math.atan(((h_x - R) - t_x) / (t_y - R));
		//
		if(wDegree > tDegree)
			return 1;
		else if(wDegree < tDegree)
			return 2;
		return 3;
	}
	
	
	// 흰 공을 중심으로 목적구가 밖에 있을 때
	public static double getDegreeOut1(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan(((h_x-R)-(w_x)) / ((h_y-R)-(w_y)));
		double 라 = Math.atan(((h_x-R)-t_x) / ((h_y-R)-t_y));
		double 다 = 가 - 라;
		
		double a = Math.sqrt(Math.pow(((h_y-R)-(w_y)), 2) + Math.pow(((h_x-R)-(w_x)), 2));
		double b = Math.sqrt(Math.pow(((h_x-R)-t_x), 2) + Math.pow(((h_y-R)-t_y), 2));
		
		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));
		
		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad) 
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));
		
		return Math.toDegrees(가 + 나);
	}
	
	// 흰 공을 중심으로 목적구가 안에 있을 때
		public static double getDegreeIn1(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
			double 가 = Math.atan(((h_x-R)-(w_x)) / ((h_y-R)-(w_y)));

			double 라 = Math.atan(((h_y-R)-t_y) / ((h_x-R)-t_x));
			double 다 = 90 - 가 - 라;

			double a = Math.sqrt(Math.pow(((h_y-R)-(w_y)), 2) + Math.pow(((h_x-R)-(w_x)), 2));
			double b = Math.sqrt(Math.pow(((h_x-R)-t_x), 2) + Math.pow(((h_y-R)-t_y), 2));

			// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
			double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

			// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
			double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));
			
			return Math.toDegrees(가 - 나);
		}


	// 흰 공을 중심으로 목적구가 밖에 있을 때
	public static double getDegreeOut4(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan(((h_y-R)-(w_y)) / ((h_x-R)-(w_x)));
		double 라 = Math.atan(((h_y-R)-t_y) / ((h_x-R)-t_x));
		double 다 = 가 - 라;

		double a = Math.sqrt(Math.pow(((h_y-R)-(w_y)), 2) + Math.pow(((h_x-R)-(w_x)), 2));
		double b = Math.sqrt(Math.pow(((h_x-R)-t_x), 2) + Math.pow(((h_y-R)-t_y), 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 + 나);
	}

	// 흰 공을 중심으로 목적구가 안에 있을 때
	public static double getDegreeIn4(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan(((h_y-R)-(w_y)) / ((h_x-R)-(w_x)));
		double 라 = Math.atan(((h_y-R)-t_y) / ((h_x-R)-t_x));
		double 다 = 90 - 가 - 라;

		double a = Math.sqrt(Math.pow(((h_y-R)-(w_y)), 2) + Math.pow(((h_x-R)-(w_x)), 2));
		double b = Math.sqrt(Math.pow(((h_x-R)-t_x), 2) + Math.pow(((h_y-R)-t_y), 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 - 나);
	}

	// 흰 공을 중심으로 목적구가 밖에 있을 때
	public static double getDegreeOut3(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan((w_x) - (h_x+R) / (w_y) - (h_y+R));
		double 라 = Math.atan((t_x - R) / (t_y - R));
		double 다 = 가 - 라;

		double a = Math.sqrt(Math.pow(((w_y)-(h_y + R)), 2) + Math.pow(((w_x)-(h_x + R)), 2));
		double b = Math.sqrt(Math.pow((t_x-R), 2) + Math.pow((t_y-R), 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 + 나);
	}

	// 흰 공을 중심으로 목적구가 안에 있을 때
	public static double getDegreeIn3(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan((w_x) - (h_x+R) / (w_y) - (h_y+R));
		double 라 = Math.atan((t_x - R) / (t_y - R));
		double 다 = 90 - 가 - 라;

		double a = Math.sqrt(Math.pow(((w_y)-(h_y + R)), 2) + Math.pow(((w_x)-(h_x + R)), 2));
		double b = Math.sqrt(Math.pow((t_x-R), 2) + Math.pow((t_y-R), 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 - 나);
	}

	// 흰 공을 중심으로 목적구가 밖에 있을 때
	public static double getDegreeOut2(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan(((h_y - R) - w_y) / (w_x - R));
		double 라 = Math.atan(((h_y - R) - t_y) / (t_x - R));
		double 다 = 가 - 라;

		double a = Math.sqrt(Math.pow(((h_y - R) - w_y), 2) + Math.pow(((w_x)- R), 2));
		double b = Math.sqrt(Math.pow((t_x-R), 2) + Math.pow((h_y-R) - t_y, 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 + 나);
	}

	// 흰 공을 중심으로 목적구가 안에 있을 때
	public static double getDegreeIn2(float w_x, float w_y, float t_x, float t_y, float h_x, float h_y) {
		double 가 = Math.atan(((h_y - R) - w_y) / (w_x - R));
		double 라 = Math.atan(((h_y - R) - t_y) / (t_x - R));
		double 다 = 90 - 가 - 라;

		double a = Math.sqrt(Math.pow(((h_y - R) - w_y), 2) + Math.pow(((w_x)- R), 2));
		double b = Math.sqrt(Math.pow((t_x-R), 2) + Math.pow((h_y-R) - t_y, 2));

		// d^2 = a^2 + (b+2r)^2 - 2a(b+2r)cos다
		double d = Math.sqrt(Math.pow(a, 2) + Math.pow(b+2*R, 2) - (2*a*(b+2*R)*Math.cos(다)));

		// 나 = acos((a^2 + d^2 - (b+2r)^2)/2ad)
		double 나 = Math.acos((Math.pow(a, 2) + Math.pow(d, 2) - Math.pow((b + 2*R), 2)) / (2 * a * d));

		return Math.toDegrees(가 - 나);
	}
}
