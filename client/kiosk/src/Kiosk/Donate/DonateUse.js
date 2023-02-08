import React from "react";
import styles from "./DonateUse.module.css"
import { useLocation, useNavigate } from "react-router-dom";
import first from "../img/first.jpg"
import second from "../img/second.jpg"
import { AiOutlineArrowLeft } from 'react-icons/ai';
import { BiHomeAlt } from 'react-icons/bi';
import {BsFillArrowRightCircleFill} from "react-icons/bs"
import axios from 'axios'

function DonateUse(props) {
    
    const navigate = useNavigate()
    // 페이지 이동

    const location = useLocation()

    console.log(location)
    const isnavigate = location.state.isnavigate
    const locker = location.state.Locker

    function barcodeInput(e) {
        let event=window.event || e;
        if(isnavigate === true) {
                console.log(event.target.value)
                const data = {isnavigate: isnavigate, Locker :locker, User: event.target.value}
                const onClickHandlerBarcodeRead =() => {
                    navigate('/BarcodeRead', {state: data})
                }
                onClickHandlerBarcodeRead()
            } else {
                // 수령 페이지로 이동
                const data = {isnavigate: isnavigate, Locker :locker, User: e.target.value}
                const onClickHandlerReceiptConfirm =() => {
                    navigate('/ReceiptConfirm', {state: data})
                }
                onClickHandlerReceiptConfirm()
            }
        }
    
    const onClickHandlerHome = () => {
        navigate('/')
    }
    const goBack = () => {
        navigate(-1)
    }
    //수령일때랑 기부일때랑 바꿔서 처리 if로 해서
    return (
        // <div>
            <div>
                <div className={styles.myImg}>
                    <button className={styles.circle} onClick={goBack}>
                        <AiOutlineArrowLeft className={styles.iconStyle}/>
                    </button>
                        {/* <div className={styles.buttonOne} onClick={onClickHandlerBarcodeRead}> */}
                        <div className={styles.buttonOne}>
                            <h3 className={styles.h3Align}>STEP1</h3>
                            {/* <img src={}  /> */}
                            <BsFillArrowRightCircleFill className={styles.arrowRight} size={80}/>
                            <h3 className={styles.h3AlignOne}>STEP2</h3>
                            
                        </div>
                        <input className={styles.barcode} type="text" onChange={barcodeInput} autoFocus/>
                        {/* onChange={onChangeHandler} value={barcode}  */}
                    <button className={styles.homeCircle} onClick={onClickHandlerHome} >
                        <BiHomeAlt className={styles.iconStyle}/>
                    </button>
                </div>
            </div>
            /* <label htmlFor="title" onSubmit={}></label>
            <input type="text" required id="title" />
        </div> */
        )
}

export default DonateUse