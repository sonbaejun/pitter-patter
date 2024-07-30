import React from "react";
import './LandingPage.css';
import Header from "./Header.jsx";
import NavBar from "../../components/NavBar.jsx";
import InputH from "../../components/modal/InputH.jsx";
import ProfileList from "../../components/ProfileList.jsx";

function LandingPage() {
    return (
        <div>
            <Header />
            {/* <NavBar /> */}
            {/* <InputH /> */}
            <ProfileList />
        </div>
    );
}

export default LandingPage;