import { Route } from "react-router-dom";

function ProfileList() {
    const children = ['src/assets/img/User/SingingBanana.png', 'src/assets/img/User/SingingBanana.png', 'src/assets/img/User/SingingBanana.png', 'src/assets/img/User/SingingBanana.png']

    return (
        <div>
            <div className="profile-list">

                {children.map((imgsrc, index) => (
                    <div className="children-list-img">
                        <div className="children-profile-item">
                            <Route to='/'>
                                <img key={index} src={`${imgsrc}`} alt="profile" className="children-item-img" />
                            </Route>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProfileList;