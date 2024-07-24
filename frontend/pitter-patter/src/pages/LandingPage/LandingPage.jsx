import React from "react";
import './LandingPage.css';
import Header from "./Header.jsx";
import NavBar from "../../components/NavBar.jsx";

function LandingPage() {
    return (
        <div>
            {/* <Header /> */}
            <NavBar />
            <h1>Pitter Patter</h1>
            <p>Welcome to Pitter Patter</p>
            <p>This is a simple social media platform.</p>
            <p>To get started, sign up or log in.</p>
            <p>Feel free to explore the features and create your own posts.</p>
            <p>Happy blogging!</p>
        </div>
    );
}

export default LandingPage;