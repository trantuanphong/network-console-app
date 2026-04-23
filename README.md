# NetworkConsoleApp

**Mục tiêu:** Công cụ console giúp:  
1. Hiển thị địa chỉ IP local  
2. Hiển thị danh sách IP trong network  
3. Tìm IP cụ thể trong network  

---

## Yêu cầu

- Hệ điều hành: Windows, Linux, MacOS  
- Không cần cài Java (đã bundle JRE)  
- Chỉ cần tải file artifact và chạy  

---

## Cách tải

1. Truy cập repository GitHub: [Link repo]  
2. Chọn **Actions → build gần nhất → Artifacts**  
3. Download folder tương ứng hệ điều hành:  
   - **Windows:** `NetworkConsoleApp-windows-latest`  
   - **Linux:** `NetworkConsoleApp-ubuntu-latest`  
   - **Mac:** `NetworkConsoleApp-macos-latest`  

---

## Cách chạy

### Windows
1. Mở folder artifact  
2. Double-click **NetworkConsoleApp.exe**  
3. Menu console sẽ xuất hiện, chọn chức năng mong muốn  

### Linux
1. Mở terminal, chuyển đến folder artifact  
2. Thêm quyền chạy nếu cần 
```
chmod +x NetworkConsoleApp
```
3. Chạy file `NetworkConsoleApp`  

### MacOS
1. Double-click **NetworkConsoleApp.app**  
2. Nếu MacOS cảnh báo, chọn **Open anyway** trong **System Preferences → Security & Privacy**  

---

## Sử dụng Menu

1. **1 – Hiển thị địa chỉ IP local**  
2. **2 – Hiển thị danh sách IP trong network**  
3. **3 – Tìm một IP cụ thể trong network**  
4. **4 – Thoát chương trình**  

Nhập số tương ứng và nhấn Enter để chọn.  

---

## Notes

- Quét network có thể mất vài giây  
- Chức năng tìm IP sẽ báo **"Found"** hoặc **"Không tìm thấy"**  
- Đảm bảo máy tính đang kết nối cùng mạng LAN để quét IP  