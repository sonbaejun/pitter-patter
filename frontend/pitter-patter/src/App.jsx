import { BrowserRouter, Routes, Route } from "react-router-dom"
import LandingPage from "./pages/LandingPage/LandingPage"
import ChildPage from "./pages/Child/ChildPage"
import Login from "./pages/User/Login"
import Attendance from "./pages/ETC/Attendance/Attendance"
import AttendanceEvent from "./pages/ETC/Attendance/AttendanceEvent"

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          {/* LandingPage */}
          <Route path="/" element={<LandingPage />} />
          
          {/* User */}
          <Route path="/login" element={<Login />} />
          
          {/* Child */}
          <Route path="/child" element={<ChildPage />} />

          {/* ETC */}
          <Route path="/attendance" element={<Attendance />} />
          <Route path="/attendance-event" element={<AttendanceEvent />} />

        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App
