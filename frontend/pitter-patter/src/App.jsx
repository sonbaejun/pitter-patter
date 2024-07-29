import { BrowserRouter, Routes, Route } from "react-router-dom"
import LandingPage from "./pages/LandingPage/LandingPage"
import ChildPage from "./pages/Child/ChildPage"

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/child" element={<ChildPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App
