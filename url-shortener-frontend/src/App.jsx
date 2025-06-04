import { useState } from 'react'
import './App.css'

function App() {
  const [texto, setTexto] = useState('')
  const [resposta, setResposta] = useState('')

  const enviarTexto = async () => {
    try {
      const response = await fetch('http://localhost:8080/shorten', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ originalUrl: texto })
      })

      if (!response.ok) {
        throw new Error('Request error')
      }

      const data = await response.json()
      setResposta("http://localhost:8080/shorten/" + data.shortUrl)
    } catch (error) {
      setResposta('Error sending message.')
    }
  }

  return (

    <div className='url-shortener'>
      <div className='url-shortener__title'>
        <h1>URL Shortener</h1>
      </div>
      
      <div className='url-shortener__actions'>
        <input className='url-shortener__actions-input'
          type="text"
          value={texto}
          onChange={(e) => setTexto(e.target.value)}
          placeholder="https://www.google.com/"
        />

        <button className='url-shortener__actions-button' onClick={enviarTexto}>
          Shorten URL
        </button>
      </div>

      <div className='url-shortener__response'>
        <p className='url-shortener__response-text'>
          Shortened URL: <a href={resposta} target="_blank" rel="noopener noreferrer">{resposta}</a>
        </p>
      </div>
    </div>

  )
}

export default App
